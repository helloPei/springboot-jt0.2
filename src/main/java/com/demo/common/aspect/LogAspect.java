package com.demo.common.aspect;

import java.lang.reflect.Method;
import java.util.Date;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.demo.common.annotation.RequiredLog;
import com.demo.common.util.IPUtils;
import com.demo.common.util.ShiroUtils;
import com.demo.mapper.LogMapper;
import com.demo.pojo.Log;

/**
 * RequiredLog 注解实现
 * 	借助@Aspect注解描述此类为一个切面对象，在此类实现日志操作
 * 	例如： 用户添加，修改等业务操作执行要进行日志记录
 * @author Administrator
 *
 */
@Aspect
@Service
public class LogAspect {
	
	@Autowired
	private LogMapper logMapper;
	
	/**
	 * 切入点的定义(借助@Pointcut注解进行描述)
	 */
//	@Pointcut("bean(userServiceImpl)")
	@Pointcut("@annotation(com.demo.common.annotation.RequiredLog)")
	public void doPointCut(){}//切入点
	
	/**
	 * @Around 修饰的方法为一个环绕通知（可以在目标方法执行之前和之后添加扩展业务）
	 * @param joinPoint	连接点（封装了要执行的具体方法对象信息）
	 * @return
	 */
	//@Around("bean(sysUserServiceImpl)")//切入点
	@Around("doPointCut()")
	public Object aroundMethod(ProceedingJoinPoint joinPoint)throws Throwable{
		//1.添加扩展功能
		long startTime = System.currentTimeMillis();
		long endTime = System.currentTimeMillis();
		//2.执行目标方法(可以基于业务不执行目标方法)
		//result为目标方法的返回值
		Object result = joinPoint.proceed();//通过反射机制调用目标方法
		//3.添加扩展功能
		saveObject(joinPoint, endTime - startTime);
		return result;
	}
	
	/**
	 * 将用户行为数据写入到数据库中
	 * @param joinPoint
	 * @param time
	 * @throws JsonProcessingException 
	 * @throws NoSuchMethodException 
	 */
	private void saveObject(ProceedingJoinPoint joinPoint, long time)
			throws JsonProcessingException, NoSuchMethodException{
		//1.获取要记录的用户行为数据
		String ip = IPUtils.getIpAddr();
		//1.2获取登录用户名
		String username = ShiroUtils.getPrincipal().getUsername();
		//1.3获取用户操作
		System.out.println(joinPoint.getSignature().getClass().getName());
		//1.3.1获取目标方法对象(先获取目标类，再获取目标方法对象)
		Class<?> targetCls = joinPoint.getTarget().getClass();
		Method targetMethod = getTargetMethod(targetCls, joinPoint);//方法快速提取方法快捷键：alt + shift + m
		//1.3.2获取目标方法对象上的注解
		RequiredLog rLog = targetMethod.getDeclaredAnnotation(RequiredLog.class);
		//1.3.3获取注解中定义的操作名
		String operation = rLog != null ? rLog.operation() : "unkown";
		//1.4获取方法名
		String method = targetCls.getSimpleName()+"."+targetMethod.getName();
		String params = new ObjectMapper()//jackson
				.writeValueAsString(joinPoint.getArgs());
		//2.封装用户的行为数据
		Log log = new Log();
		log.setIp(ip);				//	设置IP地址
		log.setUsername(username);	//	设置操作用户
		log.setOperation(operation);//	设置用户的操作
		log.setMethod(method);		//	设置请求方法
		log.setParams(params);		//	设置请求参数
		log.setTime(time);			//	设置时长
		log.setCreateDate(new Date());	//	设置创建日期
		//3.将用户行为数据写入到数据库中
		logMapper.insert(log);
//		logMapper.insertObject(log);
	}
	
	/**
	 *	 获取目标方法对象
	 * @param targetCls
	 * @param joinPoint
	 * @return
	 * @throws NoSuchMethodException
	 */
	private Method getTargetMethod(Class<?> targetCls, ProceedingJoinPoint joinPoint)
			throws NoSuchMethodException{
		//获取方法签名对象
		MethodSignature ms = (MethodSignature)joinPoint.getSignature();
//		//获取方法参数类型
//		Class<?>[] paramTypes = ms.getMethod().getParameterTypes();
//		//获取目标方法(先获取目标对象，再获取目标方法)
//		Method targetMethod = targetCls.getDeclaredMethod(ms.getName(), paramTypes);
//		return targetMethod;
		Method method = ms.getMethod();//获取接口方法对象
		return method;
	}
	
}
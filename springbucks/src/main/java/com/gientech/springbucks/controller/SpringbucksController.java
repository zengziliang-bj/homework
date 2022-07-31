package com.gientech.springbucks.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gientech.springbucks.model.Student;
import com.gientech.springbucks.model.User;
import com.gientech.springbucks.service.CacheService;
import com.gientech.springbucks.service.UserService;
import com.gientech.springbucks.util.BitMap;
import com.gientech.springbucks.util.IdGenerateUtil;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestController
@RequestMapping("/userInfo")
@Api(tags = "用户模块--作业")
public class SpringbucksController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private CacheService cacheService;
	
	/**
	 * （1）实现：查询，查询时需要实现翻页 查询时增加将结果缓存到 redis
	 * 
	 * URL：http://localhost:58081/userInfo/getUserInfoByPage
	 */
	@RequestMapping("/getUserInfoByPage")
	public void getUserInfoByPage(int pageNum, int pageSize) {
		
		PageInfo<User> userPageInfo = userService.getUserByPage(pageNum, pageSize);
		List<User> userPageList = userPageInfo.getList();
		for (User user : userPageList) {
			// 查询时增加将结果缓存到 redis
			try {
				cacheService.add(user.getUsername(), user.getPassword());
			} catch (Exception e) {
				e.printStackTrace();
				log.info("缓存结果：{}, 写入失败", cacheService.get(user.getUsername()));
			}

			log.info("缓存结果：{}", cacheService.get(user.getUsername()));
		}
	}

	/**
	 * （1）实现：查询，查询时需要实现根据主键批量查询 查询时增加将结果缓存到 redis
	 * URL：http://localhost:58081/userInfo/getUserInfoById?id=01
	 */
	@GetMapping("/getUserInfoById")
	public void getUserInfoById(int id) {
		// 根据主键查询--将结果缓存到 redis
		User user = userService.queryUserById(id);

		try {
			cacheService.add(user.getUsername(), user.getPassword());
		} catch (Exception e) {
			e.printStackTrace();
			log.info("缓存结果：{}, 写入失败", cacheService.get(user.getUsername()));
		}
		// 输出缓存结果
		log.info("缓存结果：{}", cacheService.get(user.getUsername()));
	}
	
	/**
	 * （1）新增-加入事务管理，通过注解 
	 * URL：http://localhost:58081/userInfo/addUserInfo
	 */
	@GetMapping("/addUserInfo")
	public void addUserInfo() {
		User user = new User();
		user.setUsername("测试1");
		user.setPassword(String.valueOf(System.currentTimeMillis()));
		userService.addUser(user);
	}
	
	/**
	 * （1）修改加入事务管理，通过注解 
	 * url:http://localhost:58081/userInfo/updateUserInfo?id=2
	 */
	@GetMapping("/updateUserInfo")
	public void updateUserInfo(int id) {

		User user = userService.queryUserById(id);
		user.setPassword(String.valueOf(System.currentTimeMillis()));
		userService.modifyUserById(user);
	}

	/**
	 * （1）删除加入事务管理，通过注解 
	 * URL：http://localhost:58081/userInfo/deleteUserInfo?id=2
	 */
	@GetMapping("/deleteUserInfo")
	public void deleteUserInfo(int id) {

		User userList = userService.queryUserById(id);

		if (!ObjectUtils.isEmpty(userList)) {
			try {
				userService.deleteUserById(id);
			} catch (Exception e) {
				e.printStackTrace();
				log.info("{} 用户删除失败不存在",id);
			}
		} else {
			log.info("{} 用户不存在",id);
		}
	}

	/**
	 * （5）实现分数排名或者排行榜；
	 * url:http://localhost:58081/userInfo/getStudentScore
	 */
	@GetMapping("/getStudentScore")
	public String getStudentScore() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("张三", new BigDecimal("90")));
		list.add(new Student("李四", new BigDecimal("89")));
		list.add(new Student("王五", new BigDecimal("99.5")));
		list.add(new Student("赵四", new BigDecimal("62")));

		list.sort(new Comparator<Student>() {
			@Override
			public int compare(Student student1, Student student2) {
				BigDecimal score1 = student1.getScore();
				BigDecimal score2 = student2.getScore();
				return score2.compareTo(score1);
			}
		});
		
		
		StringBuilder sb = new StringBuilder();
		
		int i = 1;
		for (Student stu : list) {

			log.info("姓名：{}，成绩：{}，名次：{}", stu.getUsername(), stu.getScore(), i);
			
			sb.append("姓名:").append(stu.getUsername()).append(",成绩:").append(stu.getScore()).append(",名次:").append(i).append("/r/n");
			
			i++;
		}
		
		
		return sb.toString();
	}

	/**
	 * （5）实现全局 ID 生成；
	 * url:http://localhost:58081/userInfo/getIdGenerate
	 */
	@GetMapping("/getIdGenerate")
	public String getIdGenerate() {
		IdGenerateUtil util = new IdGenerateUtil();
//		log.info("---  {}", util.nextId());
		
		return String.valueOf(util.nextId());
	}

	/**
	 * （5）基于 Bitmap 实现 id 去重；
	 * url:http://localhost:58081/userInfo/bitMapQuChong
	 */
	@GetMapping("/bitMapQuChong")
	public void bitMapQuChong() {
		new BitMap().findDuplicate();
		new BitMap().findDup_jdk();
	}
}

package com.peng.listener;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.mysql.jdbc.AbandonedConnectionCleanupThread;
/**
 * 
* @ClassName: TomcatContextFinalListener 
* @Description: listener比filter，servlet的load- 更早启用
* @author pengcq 412940226@qq.com 
* @date 2018年1月5日 下午7:46:12 
*
 */
@WebListener
public class TomcatContextFinalListener implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent arg0) {
		Enumeration<Driver> drivers = DriverManager.getDrivers();
		Driver d = null;
		while (drivers.hasMoreElements()) {
			d = drivers.nextElement();
			try {
				DriverManager.deregisterDriver(d);
				System.out.println(String.format("TomcatContextFinalListener:Driver %s deregistered", d));
				AbandonedConnectionCleanupThread.shutdown();
			} catch (SQLException ex) {
				ex.printStackTrace();
				System.out.println(String.format("TomcatContextFinalListener:Error deregistering driver %s", d) + ":" + ex);
			} catch (InterruptedException e) {
				System.out.println("TomcatContextFinalListener:SEVERE problem cleaning up: " + e.getMessage());
				e.printStackTrace();
			}
			
		}
	}

	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("TomcatContextFinalListener.contextInitialized");
	}

}

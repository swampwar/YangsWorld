package com.yang.myapp.database;

import java.io.IOException;
import java.util.Properties;

import org.hsqldb.Server;
import org.hsqldb.persist.HsqlProperties;
import org.hsqldb.server.ServerAcl.AclFormatException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.SmartLifecycle;

public class HSQLDB implements SmartLifecycle{ // TODO SmartLifecycle 이놈 뭐지?
	
	private final Logger logger = LoggerFactory.getLogger(HSQLDB.class);
	private HsqlProperties properties;
	private Server server;
	private boolean running = false;

	public HSQLDB(Properties properties) {
		this.properties = new HsqlProperties(properties);
	}

	@Override
	public boolean isRunning() { // TODO 언제 호출되는 것인지?

		if(server != null)
			server.checkRunning(running);
		
		return running;
	}

	@Override
	public void start() {
		if(server == null) {
			logger.info("Starting HSQLDB Server");
			server = new Server();
			
			try {
				server.setProperties(properties);
				server.start();
				running = true;
			} catch (AclFormatException afe) {
				logger.error("Error! Fail to start DataBase", afe);
			} catch (IOException ioe) {
				logger.error("Error! Fail to start DataBase", ioe);
			}
		}
		
	}

	@Override
	public void stop() {
		logger.info("Stopping HSQLDB Server");
		
		if(server != null) {
			server.stop();
			running = false;
		}
	}

	@Override
	public int getPhase() {
		return 0;
	}

	@Override
	public boolean isAutoStartup() {
		return true;
	}

	@Override
	public void stop(Runnable runnable) {
		stop();
		runnable.run();
	}

}

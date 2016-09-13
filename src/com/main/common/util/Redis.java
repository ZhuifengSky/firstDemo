package com.main.common.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;


public class Redis {

//	public static String REDIS_ADDRESS = ConstantsUtil.tjProperty.get("REDIS_ADDRESS");
//	public static String REDIS_PASSWORD = ConstantsUtil.tjProperty.get("REDIS_PASSWORD");
	public static String REDIS_ADDRESS = Utility.REDIS_ADDRESS;
	public static String REDIS_PASSWORD = Utility.REDIS_PASS;

	private static ShardedJedisPool shardedJedisPool = null;// 切片连接池

	/** 初始化切片池(分布式连接池异步调用) */
	private static void initialShardedPool() {
		JedisPoolConfig config = new JedisPoolConfig();
		/*config.setMaxTotal(5000); // 最大连接数,-1不限制
		config.setMaxIdle(100); // 初始化空闲的连接数
		config.setMaxWaitMillis(60 * 1000); // 最大等待时间(毫秒)
		config.setTestOnBorrow(true); // 获得一个jedis实例的时候是否检查连接可用性(ping())
		// slave链接
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		String[] address = REDIS_ADDRESS.split(",");
		for (int i = 0; i < address.length; i++) {
			String[] param = address[i].split(":");
			JedisShardInfo jedisShardInfo = new JedisShardInfo(param[0], Integer.parseInt(param[1]));
			jedisShardInfo.setPassword(REDIS_PASSWORD);
			shards.add(jedisShardInfo);
		}
		shardedJedisPool = new ShardedJedisPool(config, shards);*/
	}

	/** 获取ShardedJedis连接 */
	public static ShardedJedis getConn() {
		if (shardedJedisPool == null) {
			initialShardedPool();
		}
		return shardedJedisPool.getResource();
	}

	/** 关闭ShardedJedis连接 */
	public static void close(ShardedJedis jedis) {
		if (jedis != null) {
			shardedJedisPool.returnResource(jedis);
		}
	}

	/** 放值 */
	public static boolean set(String key,
			String value) {
		ShardedJedis jedis = null;
		try {
			jedis = Redis.getConn();
			if ("OK".equals(jedis.set(key, value))) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Redis.close(jedis);
		}
		return false;
	}

	/** 放值 */
	public static boolean set(String key,
			String value,
			int seconds) {

		ShardedJedis jedis = null;
		try {
			jedis = Redis.getConn();
			if ("OK".equals(jedis.set(key, value))) {
				jedis.expire(key, seconds);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Redis.close(jedis);
		}
		return false;
	}

	/** 放map值 */
	public static boolean hmset(String key,
			Map<String, String> hash) {
		ShardedJedis jedis = null;
		try {
			jedis = Redis.getConn();
			if ("OK".equals(jedis.hmset(key, hash))) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Redis.close(jedis);
		}
		return false;
	}

	/** 放map值 */
	public static boolean hmset(String key,
			Map<String, String> hash,
			int seconds) {
		ShardedJedis jedis = null;
		try {
			jedis = Redis.getConn();
			if ("OK".equals(jedis.hmset(key, hash))) {
				jedis.expire(key, seconds);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Redis.close(jedis);
		}
		return false;
	}

	public static List<String> hmget(String key,
			String... field) {
		ShardedJedis jedis = null;
		try {
			jedis = Redis.getConn();
			return jedis.hmget(key, field);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Redis.close(jedis);
		}
		return null;
	}

	/** 放map值 */
	public static boolean hset(String key,
			String field,
			String value) {
		ShardedJedis jedis = null;
		try {
			jedis = Redis.getConn();
			if ("OK".equals(jedis.hset(key, field, value))) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Redis.close(jedis);
		}
		return false;
	}

	public static String hget(String key,
			String field) {
		ShardedJedis jedis = null;
		try {
			jedis = Redis.getConn();
			return jedis.hget(key, field);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Redis.close(jedis);
		}
		return null;
	}

	/**
	 * 设置过期时间
	 * 
	 * @author fanxd
	 * @param key
	 * @param seconds
	 */
	public static void expire(String key,
			int seconds) {
		ShardedJedis jedis = null;
		try {
			jedis = Redis.getConn();
			jedis.expire(key, seconds);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Redis.close(jedis);
		}
	}

	public static boolean exists(String key) {
		ShardedJedis jedis = null;
		boolean result = false;
		try {
			jedis = Redis.getConn();
			result = jedis.exists(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Redis.close(jedis);
		}
		return result;
	}

	/** 取值,不存在 null */
	public static String get(String key) {
		ShardedJedis jedis = null;
		try {
			jedis = Redis.getConn();
			return jedis.get(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Redis.close(jedis);
		}
		return null;
	}

	/** 删除值 */
	public static boolean del(String key) {
		ShardedJedis jedis = null;
		try {
			jedis = Redis.getConn();
			if (jedis.del(key) == 1) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Redis.close(jedis);
		}
		return false;
	}

	public static void main(String[] args) {
		// System.out.println(Redis.set("1", "1"));

		// System.out.println(Redis.get("1"));

		// System.out.println(Redis.del("1"));

		// System.out.println(Redis.get("0j69vn6vqe22bdpoelonds8gp1"));

//		 Map<String,String> map20 = new HashMap<String,String>();
//		 map20.put("code", "200");
//		 map20.put("userId", "103737");
//		 map20.put("ticket", "TGT-TICKET-20");
//		 map20.put("expiredTime", "20160727");
//		 Redis.hmset("TGT-TICKET-20", map20);
//		 
//		 Map<String,String> map21 = new HashMap<String,String>();
//		 map21.put("code", "200");
//		 map21.put("userId", "103737");
//		 map21.put("ticket", "TGT-TICKET-21");
//		 map21.put("expiredTime", "20160727");
//		 Redis.hmset("TGT-TICKET-21", map21);
		System.out.println(Redis.del("TGT-TICKET-20"));
		 System.out.println(Redis.hget("TGT-TICKET-20", "userId"));
		 System.out.println(Redis.hget("TGT-TICKET-21", "userId"));
		 System.out.println(Redis.exists("TGT-TICKET-20"));
		 System.out.println(Redis.exists("TGT-TICKET-21"));
//		Redis.hset("website2", "code", "201");
//		System.out.println(Redis.hget("website2", "code"));
//		System.out.println(Redis.hmget("website2", "ticket"));

	}

}

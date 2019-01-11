package com.main.aliPay.config;

public class AlipayConfig {
	// 商户appid
	public static String APPID = "2016102702359589";
	// 私钥 pkcs8格式的
	
	public static String RSA_PRIVATE_KEY = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALlfzrLk0vhMChn9s+o1e/uxeHqnVKkKc8n91zUNTHI1k3fmWyqtXJmH9cIcWc6siTThDEN8bMwVLN3965DG1fWXr1rzSS72wdTZTU8ez/cdsIvO+Y5t2Z/WD26vgmpxRcFpKywQgW8y2sqRQc35R7MadOr8+r+GlUfzl9yAqas5AgMBAAECgYAlVAqecX+eKkm6dCEfn4eI5nLZWAqvQ4CPg0Mr1rK3KNy6PzPKg0BrVjqBzQ20lX/Hmy3KBSsvaXAwf6pI7BE3XFJkEEt2246dtb76hc9JDGct08haEbuAqjd+HdW023Lo2C9TFBU71xcKYO5fdVkYUxer+MXVF3/5ctbd1C6aZQJBAOmW+yd4h6covZfT1/9LlknnVFH5Owc4z936FH7MUSHMtAYp7WvKzaOsoWLHt02Wj8moRJwe8evhRhGS3jQivE8CQQDLKKRWLFi6UYtn8otq+vuECPSLmtEtmvc8nV33c2nPgajS6SCgUsUXPh3afKQ+x2TqzY911P84BcDEKMostJX3AkBbbSfCTC+0IoMKkPUCzF/3bx6WsxkCe58If+BTvL6onwl7PB/cR9VzEZddJVQ+fwaqZDzuakJAE70sFbL47vuLAkBxuSh1DJIGikstPvqIQkK1IIYz99AMZWjsx3KoaDTc8cnddp7K4EpvvlfbzFXsxpVZUwRxg2/ynlXP+L1j1Rr1AkEAgPIiewCJrkKLdfsTgBEFMI6fNHDeNBqxpKHIC9LfC1zbzllklN0fDTyztACZfeSc89nJHBB2wGsDRg0XWlY5zQ==";
	// 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http:///www.socrazy.com/pays/alipay/alipayCallBack";
	// 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
	public static String return_url = "http://www.socrazy.com/pays/alipay/alipayReturn";
	// 请求网关地址
	public static String URL = "https://openapi.alipay.com/gateway.do";
	// 编码
	public static String CHARSET = "UTF-8";
	// 返回格式
	public static String FORMAT = "json";
	// 支付宝公钥
	public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjrEVFMOSiNJXaRNKicQuQdsREraftDA9Tua3WNZwcpeXeh8Wrt+V9JilLqSa7N7sVqwpvv8zWChgXhX/A96hEg97Oxe6GKUmzaZRNh0cZZ88vpkn5tlgL4mH/dhSr3Ip00kvM4rHq9PwuT4k7z1DpZAf1eghK8Q5BgxL88d0X07m9X96Ijd0yMkXArzD7jg+noqfbztEKoH3kPMRJC2w4ByVdweWUT2PwrlATpZZtYLmtDvUKG/sOkNAIKEMg3Rut1oKWpjyYanzDgS7Cg3awr1KPTl9rHCazk15aNYowmYtVabKwbGVToCAGK+qQ1gT3ELhkGnf3+h53fukNqRH+wIDAQAB";
	// 日志记录目录
	public static String log_path = "/log";
	// RSA2
	public static String SIGNTYPE = "RSA";
}

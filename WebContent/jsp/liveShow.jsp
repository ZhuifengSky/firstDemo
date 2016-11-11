<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<iframe border="0" src="http://e.vhall.com/webinar/inituser/804157140?email=3456@vhall.com&name='ss'&hideVideoControlBar=1" width="800" height="600"></iframe>
	<script type="text/javascript">
			(function(){
			var p = {
			url:location.href,
			showcount:'1',/*是否显示分享总数,显示：'1'，不显示：'0' */
			desc:'这是一个专门做直播的网站，它里面收录了好多直播内容！',/*默认分享理由(可选)*/
			summary:'狂人学院真他妈框！',/*分享摘要(可选)*/
			title:'狂人直播真牛逼呀！',/*分享标题(可选)*/
			site:'狂人学院',/*分享来源 如：腾讯网(可选)*/
			pics:'', /*分享图片的路径(可选)*/
			style:'203',
			width:98,
			height:22
			};
			var s = [];
			for(var i in p){
			s.push(i + '=' + encodeURIComponent(p[i]||''));
			}
			document.write(['<a version="1.0" class="qzOpenerDiv" href="http://sns.qzone.qq.com/cgi-bin/qzshare/cgi_qzshare_onekey?',s.join('&'),'" target="_blank">空间分享</a>'].join(''));
			})();
  </script>
<script src="http://qzonestyle.gtimg.cn/qzone/app/qzlike/qzopensl.js#jsdate=20111201" charset="utf-8">QQ空间分享</script>
	
</body>
</html>
# 常用linux 脚本

## 常用命令
- alias
```
alias ll='ls -al --color=auto' 
alias -p
```
- ls
- ll
- cd
- pwd
- jps
- ps
```
ps -aux

```
- top

- free
```
free -m

```
- du -sh *
- df -h
- netstat 
```
netstat -nptl
```
- chmod
```
chmod +x xxx-file
chmod 777 xxx-file
chmod 777 xxx-directory -r
```
- chown
- chgrp

## 装逼命令

- sed
- awk
```
1. 统计apache日志单ip访问请求数排名:

10.0.0.41 - - [03/Dec/2010:23:27:01 +0800] "HEAD /checkstatus.jsp HTTP/1.0" 200 -
10.0.0.43 - - [03/Dec/2010:23:27:01 +0800] "HEAD /checkstatus.jsp HTTP/1.0" 200 -
10.0.0.42 - - [03/Dec/2010:23:27:01 +0800] "HEAD /checkstatus.jsp HTTP/1.0" 200 -
10.0.0.46 - - [03/Dec/2010:23:27:02 +0800] "HEAD /checkstatus.jsp HTTP/1.0" 200 -
10.0.0.42 - - [03/Dec/2010:23:27:02 +0800] "HEAD /checkstatus.jsp HTTP/1.0" 200 -
10.0.0.47 - - [03/Dec/2010:23:27:02 +0800] "HEAD /checkstatus.jsp HTTP/1.0" 200 -
10.0.0.41 - - [03/Dec/2010:23:27:02 +0800] "HEAD /checkstatus.jsp HTTP/1.0" 200 -
10.0.0.47 - - [03/Dec/2010:23:27:02 +0800] "HEAD /checkstatus.jsp HTTP/1.0" 200 -
10.0.0.41 - - [03/Dec/2010:23:27:03 +0800] "HEAD /checkstatus.jsp HTTP/1.0" 200 -
10.0.0.46 - - [03/Dec/2010:23:27:03 +0800] "HEAD /checkstatus.jsp HTTP/1.0" 200 -

awk '{print $1}' access.log|sort|uniq -c |sort -rn -k1

2. 统计服务器当前单IP连接数最大的IP地址前十
Active Internet connections (w/o servers)
Proto Recv-Q Send-Q Local AddressForeign AddressState
tcp00 124.123.3.79:80219.85.194.23:12004SYN_RECV
tcp00 124.123.3.77:80183.8.74.57:3276SYN_RECV
tcp00 124.123.3.77:80124.236.0.214:63191SYN_RECV
tcp00 124.123.3.77:80121.31.42.148:2338TIME_WAIT
tcp01023 124.123.3.77:8061.178.184.222:62683FIN_WAIT1
tcp00 124.123.3.77:80222.79.242.74:7416TIME_WAIT
tcp04839 124.123.3.77:80121.31.42.148:30638FIN_WAIT1
tcp00 124.123.3.77:80183.10.154.60:37282TIME_WAIT
tcp01 124.123.3.77:8059.49.174.176:26913CLOSING
tcp00 124.123.3.77:80121.31.42.148:1787TIME_WAIT
tcp0174 124.123.3.77:80183.8.74.57:1165CLOSING

netstat -an|grep EST|awk-F '[ :]+' '{++S[$6]} END {for (key in S) print "ip:"key"----->",S[key]}'|sort -rn -k2

```





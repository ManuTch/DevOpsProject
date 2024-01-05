FROM centos:latest
MAINTAINER houdasara fariane.houda.fh@gmail.com
RUN yum install -y httpd
RUN yum install -y git
RUN git clone https://github.com/ManuTch/DevOpsProject.git /var/www/html/
WORKDIR /var/www/html
CMD ["/usr/sbin/httpd", "-D", "FOREGROUND"]
EXPOSE 80




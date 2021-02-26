FROM postgres:latest

MAINTAINER "hieunt1912@gmail.com"

COPY schema.sql /docker-entrypoint-initdb.d/

EXPOSE 5432

CMD ["postgres"]
FROM rabbitmq:3-management

MAINTAINER "hieunt1912@gmail.com"

COPY rabbitmq.conf /etc/rabbitmq/

COPY custom_definitions.json /etc/rabbitmq/

EXPOSE 15672

CMD ["rabbitmq-server"]
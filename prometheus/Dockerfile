FROM prom/prometheus:v2.8.1
COPY config.yml /etc/prometheus/config.yml
CMD [ "--config.file=/etc/prometheus/config.yml", "--storage.tsdb.path=/prometheus" ] 
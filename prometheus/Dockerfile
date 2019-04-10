FROM prom/prometheus:v2.5.0
COPY config.yml /etc/prometheus/config.yml
CMD [ "--config.file=/etc/prometheus/config.yml", "--storage.tsdb.path=/prometheus" ] 
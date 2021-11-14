FROM mcr.microsoft.com/mssql/server:2019-latest
# Create a config directory
RUN mkdir -p /usr/config
WORKDIR /usr/config
# Bundle config source
#COPY . /usr/config
USER root
COPY entrypoint.sh /usr/config/entrypoint.sh
COPY configure-db.sh /usr/config/configure-db.sh
COPY setup.sql /usr/config/setup.sql
# Grant permissions for to our scripts to be executable
RUN chmod +x /usr/config/entrypoint.sh
RUN chmod +x /usr/config/configure-db.sh

#CMD ["/bin/bash", "-l"]

ENTRYPOINT ["/usr/config/entrypoint.sh"]
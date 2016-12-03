FROM elasticsearch:5.0.2

# Install Curator (admin shell scripts for index maintenance)
ADD package/curator.list /etc/apt/sources.list.d/
RUN apt-get update && apt-get install elasticsearch-curator

# Install X-Pack
#RUN bin/elasticsearch-plugin install x-pack
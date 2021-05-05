FROM node:alpine

RUN set -uex; \
    npm install -g forever; \
    rm -rf /root/.npm;

WORKDIR /app
RUN npm install ws

ADD package*.json ./
RUN npm install
ADD . .
EXPOSE 8081
CMD ["forever", "/app/server.js"]
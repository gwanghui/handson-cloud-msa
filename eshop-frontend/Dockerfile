FROM node:lts-alpine
WORKDIR /app
RUN npm set strict-ssl false --global
RUN npm install -g http-server
COPY package*.json ./
RUN npm install
COPY . .
ARG VUE_APP_BASE_URL
ENV VUE_APP_BASE_URL=$VUE_APP_BASE_URL
RUN npm run build

EXPOSE 8080
CMD [ "http-server", "dist" ]
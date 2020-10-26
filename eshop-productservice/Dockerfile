# build stage
FROM node:lts-alpine as build-stage
WORKDIR /app
COPY package*.json ./
RUN npm set strict-ssl false --global
RUN npm ci --only=production
COPY . .

EXPOSE 8092
CMD ["node", "index.js"]
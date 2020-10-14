# build stage
FROM node:lts-alpine as build-stage
WORKDIR /app
ARG VUE_APP_BASE_URL
ENV VUE_APP_BASE_URL=$VUE_APP_BASE_URL
COPY package*.json ./
RUN npm set strict-ssl false --global
RUN npm install --production
COPY . .
RUN npm run build

# production stage
FROM nginx:stable-alpine as production-stage
ARG VUE_APP_BASE_URL
ENV VUE_APP_BASE_URL=$VUE_APP_BASE_URL
COPY --from=build-stage /app/dist /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
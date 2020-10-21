# handson-cloud-msa
Cloud/MSA 실습

## 실행하기

### docker-compose 실행
SDS Docker 이미지 저장소인 Redii에 login 합니다.
``` bash
$ docker login sds.redii.net
```

서비스에서 저장소로 사용하는 postgreSQL과 redis를 docker-compose로 기동합니다. 

``` bash
$ docker-compose up -d
```

### 서비스 기동

#### backend

``` bash
$ cd eshop-backend
$ ./gradlew bootRun
```

#### frontend

``` bash
$ cd eshop-frontend
$ npm install
$ npm run serve
```

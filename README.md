# handson-cloud-msa
Cloud/MSA 실습

## 실행하기

### docker-compose 실행

서비스에서 저장소로 사용하는 postgreSQL과 redis를 docker-compose로 기동합니다. 

``` bash
$ docker-compose up
```

### postgreSQL 초기 설정

먼저 postgres 컨테이너의 bash를 실행합니다.

``` bash
$ docker exec -it ac_postgres_1 bash
```

psql 명령어를 사용하여 postgres에 접속합니다.

``` bash
root@40c2c597844e:/# psql -U postgres
psql (13.0 (Debian 13.0-1.pgdg100+1))
Type "help" for help.

postgres=#
```

다음 SQL을 순서대로 입력하고 `\q`를 입력하여 빠져나옵니다.
``` sql
CREATE DATABASE eshop_db;
CREATE USER eshop_user WITH ENCRYPTED PASSWORD 'password';
GRANT ALL PRIVILEGES ON DATABASE eshop_db TO eshop_user;

\q
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

# Deploy: tell Tilt what YAML to deploy
k8s_yaml(['./k8s/persistentvolume.yaml','./k8s/postgresql.yaml','./k8s/redis.yaml','./k8s/backend.yaml','./k8s/frontend.yaml'])

# Build: tell Tilt what images to build from which directories
custom_build('eshop-backend', './eshop-backend/gradlew jibDockerBuild --build-file=./eshop-backend/build.gradle --image $EXPECTED_REF', deps=['./eshop-backend/src'])
docker_build('eshop-frontend', 'eshop-frontend', build_args={'HTTP_PROXY' : 'http://70.10.15.10:8080','HTTPS_PROXY' : 'http://70.10.15.10:8080','VUE_APP_BASE_URL' : 'http://localhost:8090'})
# ...

# Watch: tell Tilt how to connect locally (optional)
k8s_resource('eshop-frontend', port_forwards=8080)
k8s_resource('eshop-backend', port_forwards=8090)
#!/bin/bash
docker-compose build service-registry
docker-compose -f docker-compose.yml config > docker-stack.yml
docker stack deploy -c docker-stack.yml --with-registry-auth service-registry
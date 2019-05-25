# Getting Started

### Guides
The following guides illustrates how to use certain features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)

# To know the version of Docker 
docker -v 

# Building a docker image from Dockerfile
docker build -f Dockerfile -t learning . 

# Display list of images
docker images

# Run Docker image in container
docker run -p 9003:9003 learning

# Check running docker containers
docker ps

# Stop running container
docker stop 74f81583b789


# Tag new container with version number
docker commit 74f81583b789   hireniya/learning:0.0.3

# Push new container to docker hub
docker push hireniya/learning:0.0.3

# Pull container from docker hub
docker pull hireniya/learning:0.0.3

# Run container in new system after pulling, it will get the image ready for run
docker run -p 9003:9003 learning

# Start the docker container
docker start 74f81583b789




============= for AWS

Create user, group in AWS
give EC2 Full access policy to group

Run below command to set secret key, password etc.. displayed in user
aws configure 

Run below command to check if get-login works.
aws get-login  

run below command to have docker acess to aws
$(aws ecr get-login --no-include-email --region ap-south-1)

tag image so it can be pushed to aws ecr
docker tag learning:latest 707914278590.dkr.ecr.ap-south-1.amazonaws.com/learning:latest

Run the following command to push this image to your newly created AWS repository:
docker push 707914278590.dkr.ecr.ap-south-1.amazonaws.com/learning:latest
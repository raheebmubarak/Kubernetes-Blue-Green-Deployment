# Blue-Green Deployment on AWS EKS

A production-style Blue-Green deployment project for a Spring Boot application using Docker, Kubernetes, Helm, Amazon EKS, Amazon RDS MySQL, Amazon ECR, and AWS Application Load Balancer.

## Architecture

Developer
   |
   v
GitHub
   |
   v
Docker Image
   |
   v
Amazon ECR
   |
   v
Amazon EKS
   |
   +-------------------+
   |                   |
   v                   v
Blue Deployment    Green Deployment
   |                   |
   +---------+---------+
             |
             v
      Kubernetes Service
             |
             v
       AWS ALB / Ingress
             |
             v
        Spring Boot App
             |
             v
       Amazon RDS MySQL

## Project Overview

This project demonstrates Blue-Green deployment using Kubernetes.

Two separate application versions are maintained:

- Blue — current production version
- Green — new version

Kubernetes Service selector controls which version receives application traffic.

This allows a new version to be deployed and tested before switching production traffic.

## Technologies Used

### Application
- Java 21
- Spring Boot
- Spring Boot Actuator
- Maven

### Containerization
- Docker
- Multi-stage Docker build
- Amazon ECR

### Kubernetes
- Kubernetes
- Amazon EKS
- Helm
- Deployments
- Services
- ConfigMap
- Secrets
- Ingress
- Readiness probes
- Liveness probes
- Namespaces

### AWS
- Amazon EKS
- Amazon ECR
- Amazon RDS MySQL
- Application Load Balancer
- AWS Load Balancer Controller
- IAM
- VPC
- Security Groups
- OIDC

## Blue-Green Deployment

The application uses two Kubernetes Deployments:

```text
Blue Deployment
    |
    |---- 2 Pods
    |
    +---- Current production version


Green Deployment
    |
    |---- 2 Pods
    |
    +---- New application version

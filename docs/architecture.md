\# AWS EKS Blue-Green Architecture



\## 1. Architecture Overview



The application is a Spring Boot application deployed using a Blue-Green deployment strategy on Amazon EKS.



The architecture consists of:



\- GitHub

\- Docker

\- Amazon ECR

\- Amazon EKS

\- Kubernetes

\- Helm

\- AWS Load Balancer Controller

\- Application Load Balancer

\- Amazon RDS MySQL

\- IAM

\- VPC

\- Security Groups



\## 2. High-Level Architecture



```text

&#x20;                   Developer

&#x20;                       |

&#x20;                       v

&#x20;                    GitHub

&#x20;                       |

&#x20;                       v

&#x20;                Docker Image Build

&#x20;                       |

&#x20;                       v

&#x20;                 Amazon ECR

&#x20;                       |

&#x20;                       v

&#x20;               +----------------+

&#x20;               |   Amazon EKS   |

&#x20;               |                |

&#x20;               |  Blue Pods     |

&#x20;               |   x2           |

&#x20;               |                |

&#x20;               |  Green Pods    |

&#x20;               |   x2           |

&#x20;               +-------+--------+

&#x20;                       |

&#x20;                       v

&#x20;               Kubernetes Service

&#x20;                version: blue

&#x20;                       |

&#x20;                       v

&#x20;             AWS Load Balancer

&#x20;                 Controller

&#x20;                       |

&#x20;                       v

&#x20;            Application Load Balancer

&#x20;                       |

&#x20;                       v

&#x20;                 Internet Users





&#x20;               Spring Boot Application

&#x20;                       |

&#x20;                       | JDBC

&#x20;                       v

&#x20;                Amazon RDS MySQL


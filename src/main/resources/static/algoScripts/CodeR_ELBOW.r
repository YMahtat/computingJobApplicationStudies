library(foreign)
library(csvread)
mydata <- read.csv(file="FrequencyMatrix.csv", header=FALSE, sep=";")
inertie.expl <- rep(0,times=10)
for (k in 2:20){
clus <- kmeans(mydata,centers=k,nstart=5)
inertie.expl[k] <- clus$betweenss/clus$totss }
dev=plot(1:20,inertie.expl,type="b",xlab="Nb. de clusters",ylab="% inertie expliquée")
dev.copy(png,'myplot2.png')
dev.off()
x=dev

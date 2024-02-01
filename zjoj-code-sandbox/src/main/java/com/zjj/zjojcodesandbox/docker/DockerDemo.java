package com.zjj.zjojcodesandbox.docker;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.*;
import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Frame;
import com.github.dockerjava.api.model.PullResponseItem;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.LogContainerResultCallback;

import java.util.List;

/**
 * @Classname DockerDemo
 * @Description TODO
 * @Author zjj
 * @Date 1/31/24 2:46 PM
 */
public class DockerDemo {
    public static void main(String[] args) throws InterruptedException {
        //Default Docker Client
        DockerClient dockerClient = DockerClientBuilder.getInstance().build();

        //Pull Image
        String image = "ghost:latest";
//        PullImageCmd pullImageCmd = dockerClient.pullImageCmd(image);
//        PullImageResultCallback pullImageResultCallback = new PullImageResultCallback() {
//            @Override
//            public void onNext(PullResponseItem item) {
//                System.out.println("image download" + item.getStatus());
//                super.onNext(item);
//            }
//        };
//        pullImageCmd.exec(pullImageResultCallback).awaitCompletion();
//        System.out.println("Download completed");

        //Create Container
        CreateContainerCmd containerCmd = dockerClient.createContainerCmd(image);
        CreateContainerResponse createContainerResponse = containerCmd
                .withCmd("hello container")
                .exec();
        System.out.println(createContainerResponse);
        String containerId = createContainerResponse.getId();

        //Check status
        ListContainersCmd listContainersCmd = dockerClient.listContainersCmd();
        List<Container> containerList = listContainersCmd.withShowAll(true).exec();
        for (Container container : containerList) {
            System.out.println(container);
        }

        //Start Container
        dockerClient.startContainerCmd(containerId).exec();

        //Logs
        LogContainerResultCallback logContainerResultCallback = new LogContainerResultCallback() {
            @Override
            public void onNext(Frame item) {
                System.out.println(item.getStreamType());
                System.out.println("logs: " + new String(item.getPayload()));
                super.onNext(item);
            }
        };

        dockerClient.logContainerCmd(containerId)
                .withStdErr(true)
                .withStdOut(true)
                .exec(logContainerResultCallback)
                .awaitCompletion();

        //Delete Container
        //dockerClient.removeContainerCmd(containerId).withForce(true).exec();

        //Delete Image
        //dockerClient.removeImageCmd(image).exec();
    }
}

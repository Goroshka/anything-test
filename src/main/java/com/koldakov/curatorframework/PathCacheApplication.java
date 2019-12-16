package com.koldakov.curatorframework;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.utils.CloseableUtils;
import org.apache.curator.utils.ZKPaths;

/**
 * Application connects to zookeeper and prints events happened for children of zNode
 * If child is added or deleted, an event will be printed
 *
 * Application is active for 5 minutes
 *
 * args[0] = address to connect
 * args[1] = zNode full name (starts with "/")
 *
 * See https://curator.apache.org/curator-recipes/index.html
 */
public class PathCacheApplication {

    private static void logEvent(String message) {
        System.out.println("PathChildrenCacheEvent: " + message);
    }

    public static void main(String[] args) throws Exception {

        String address = args[0];
        String path = args[1];

        CuratorFramework curator = null;
        PathChildrenCache cache = null;
        try {
            curator = CuratorFrameworkFactory.newClient(address, new RetryOneTime(5000));
            curator.start();

            cache = new PathChildrenCache(curator, path, false);

            // PathChildrenCacheListener to log all PathChildrenCacheEvent events
            cache.getListenable().addListener((c, event) -> {
                switch (event.getType()) {
                    case INITIALIZED:
                    {
                        logEvent("PathChildrenCache Initialized");
                        break;
                    }
                    case CHILD_ADDED:
                    {
                        logEvent("Node added: " + ZKPaths.getNodeFromPath(event.getData().getPath()));
                        break;
                    }
                    case CHILD_UPDATED:
                    {
                        logEvent("Node changed: " + ZKPaths.getNodeFromPath(event.getData().getPath()));
                        break;
                    }
                    case CHILD_REMOVED:
                    {
                        logEvent("Node removed: " + ZKPaths.getNodeFromPath(event.getData().getPath()));
                        break;
                    }
                    case CONNECTION_SUSPENDED:
                    {
                        logEvent("Connection suspended");
                        break;
                    }
                    case CONNECTION_LOST:
                    {
                        logEvent("Connection lost");
                        break;
                    }
                    case CONNECTION_RECONNECTED:
                    {
                        logEvent("Connection reconnected");
                        break;
                    }
                    default:
                    {
                        throw new IllegalArgumentException("Unknown PathChildrenCacheEvent [" + event.getType() + "]");
                    }
                }
            });
            cache.start();

            Thread.sleep(1000 * 60 * 5);
        } finally {
            CloseableUtils.closeQuietly(cache);
            CloseableUtils.closeQuietly(curator);
        }
    }
}

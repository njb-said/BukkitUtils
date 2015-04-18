# BukkitUtils
A group of useful bukkit utilities

## About
This is a collection of utilities myself and [@iCake](https://github.com/icake) created for our past servers kPvP and Kiwi.

## Maven Repository

There is a maven repository at [build.mc-api.net/plugin/repository/everything](http://build.mc-api.net/plugin/repository/everything)

Maven Configuration:

```xml
<repositories>
    <repository>
        <id>mcapi</id>
        <url>http://build.mc-api.net/plugin/repository/everything/</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>me.imnjb.bukkitutils</groupId>
        <artifactId>BukkitUtils</artifactId>
        <version>1.0.5</version>
    </dependency>
</dependencies>
```

It is suggested to [shade](http://maven.apache.org/plugins/maven-shade-plugin/) this into your plugin/project as this is **NOT** a plugin.

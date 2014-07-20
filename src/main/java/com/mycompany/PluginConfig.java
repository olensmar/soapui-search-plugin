package com.mycompany;

import com.eviware.soapui.plugins.PluginAdapter;
import com.eviware.soapui.plugins.PluginConfiguration;

@PluginConfiguration(groupId = "com.smartbear.soapui.plugins", name = "Simple Search Plugin", version = "1.0.0",
        autoDetect = true, description = "A simple plugin for searching for items in a project",
        infoUrl = "http://olensmar.blogspot.com/2014/07/getting-started-with-new-soapui-plugin.html" )
public class PluginConfig extends PluginAdapter {
}

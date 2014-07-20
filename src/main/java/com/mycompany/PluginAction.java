package com.mycompany;

import com.eviware.soapui.SoapUI;
import com.eviware.soapui.impl.wsdl.WsdlProject;
import com.eviware.soapui.model.ModelItem;
import com.eviware.soapui.plugins.ActionConfiguration;
import com.eviware.soapui.support.UISupport;
import com.eviware.soapui.support.action.support.AbstractSoapUIAction;
import com.eviware.soapui.support.components.ModelItemListDesktopPanel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@ActionConfiguration(actionGroup = "EnabledWsdlProjectActions")
public class PluginAction extends AbstractSoapUIAction<WsdlProject> {

    public PluginAction() {
        super("Item Search", "A plugin for finding project items");
    }

    @Override
    public void perform(WsdlProject wsdlProject, Object o) {
        String token = UISupport.prompt( "Provide search string", "Item Search", "" );

        List<ModelItem> searchResult = new ArrayList<>();
        findItems( searchResult, wsdlProject, token );

        if( searchResult.isEmpty())
        {
            UISupport.showErrorMessage( "No items matching [" + token + "] found in project");
            return;
        }

        UISupport.showDesktopPanel(new ModelItemListDesktopPanel("Search Result",
                        "The following items matched [" + token + "]",
                        searchResult.toArray(new ModelItem[searchResult.size()])));
    }

    private void findItems(List<ModelItem> searchResult, ModelItem parent, String token)
    {
        for( ModelItem child : parent.getChildren())
        {
            if( child.getName().matches( token ))
                searchResult.add( child );

            findItems( searchResult, child, token );
        }
    }
}

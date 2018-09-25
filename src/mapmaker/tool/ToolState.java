/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mapmaker.tool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author owner
 */
public final class ToolState {
    private static final ToolState TS = new ToolState();
    private final List<Object> options;
    
    private Tool activeTool;
    
    private final SimpleObjectProperty<Tool> activeToolProperty;
    
    private ToolState(){
        this.options = new ArrayList<>();
        activeToolProperty = new SimpleObjectProperty<Tool>(){
            @Override
            public Tool get(){
                return activeTool;
            }
            
            @Override
            public void set(Tool t){
                activeTool = t;
                fireValueChangedEvent();
            }
        };
        activeToolProperty.set(SelectTool.getTool());
    }
    
    public static ToolState getToolState(){return TS;}
    
    public void setActiveTool(Tool tool, Object ... optionList){
        activeToolProperty.set(tool);
        options.clear();
        options.addAll(Arrays.asList(optionList));
    }
    
    public Tool getActiveTool(){
        return activeToolProperty.get();
    }
    
    public SimpleObjectProperty<Tool> getActiveToolProperty(){
        return activeToolProperty;
    }
    
    public Object getOption(int index){
        return options.get(index);
    }
}

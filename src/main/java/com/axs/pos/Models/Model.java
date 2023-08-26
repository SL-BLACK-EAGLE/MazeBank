package com.axs.pos.Models;


import com.axs.pos.Views.ViewFactory;

public class Model {
    private static Model model;
    private ViewFactory viewFactory;

    private Model(){
        this.viewFactory = new ViewFactory();
    }
    public static synchronized Model getInstance(){
        if(model == null){
            model = new Model();
        }
        return model;
    }
}

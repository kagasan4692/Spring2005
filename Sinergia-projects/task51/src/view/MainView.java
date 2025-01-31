package view;

import common.AppView;
import data.service.ShopService;

import java.util.ArrayList;

public class MainView extends AppView {

    public MainView(ArrayList<AppView> children, ShopService shopService) {
        super("Магазин", children);
    }

}

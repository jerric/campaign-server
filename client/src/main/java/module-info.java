module net.lliira.game.campaign.lliiragamecampaignclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens net.lliira.game.campaign.lliiragamecampaignclient to javafx.fxml;
    exports net.lliira.game.campaign.lliiragamecampaignclient;
}
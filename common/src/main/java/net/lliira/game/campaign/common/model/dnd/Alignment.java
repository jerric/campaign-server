package net.lliira.game.campaign.common.model.dnd;

/**
 * The alignment of a charactor represents their moral attitude toward other people.
 */
public enum Alignment {
    LG("Lawful Good"),
    NG("Neutral Good"),
    CG("Chaotic Good"),
    LN("Lawful Neutral"),
    N("Neutral"),
    CN("Chaotic Neutral"),
    LE("Lawful Evil"),
    NE("Neutral Evil"),
    CE("Chaotic Evil");

    private final String label;

    Alignment(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}

public class Item {
    //Attributes
    private String name;
    private String description;


    /**
     * Creates a new item with a name and description.
     * @param name The name of the item.
     * @param description A description of the item.
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Gets the name of the item.
     * @return The item name.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the description of the item.
     * @return The item description.
     */
    public String getDescription() {
        return description;
    }
}

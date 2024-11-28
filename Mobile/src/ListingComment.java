public class ListingComment {
    private final Commenter commenter;
    private final String comment;
    ListingComment(Commenter commenter,String comment)
    {
        this.commenter=commenter;
        this.comment=comment;
    }

    public String getComment() {
        return comment;
    }

    public Commenter getCommenter() {
        return commenter;
    }
}

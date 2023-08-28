package com.thejava.section4;

public class Online {

    private Long id;
    private String title;
    private boolean closed;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isClosed() {
        return closed;
    }

    public Online(Long id, String title, boolean closed) {
        this.id = id;
        this.title = title;
        this.closed = closed;
    }

}

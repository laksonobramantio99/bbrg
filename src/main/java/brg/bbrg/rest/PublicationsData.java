package brg.bbrg.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PublicationsData {

    @JsonProperty("total_citations")
    private String totalCitations;

    @JsonProperty("publications")
    private List<Publication> publicationList;

    public String getTotalCitations() {
        return totalCitations;
    }

    public void setTotalCitations(String totalCitations) {
        this.totalCitations = totalCitations;
    }

    public List<Publication> getPublicationList() {
        return publicationList;
    }

    public void setPublicationList(List<Publication> publicationList) {
        this.publicationList = publicationList;
    }
}

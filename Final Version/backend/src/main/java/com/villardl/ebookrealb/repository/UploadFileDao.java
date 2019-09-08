package com.villardl.ebookrealb.repository;

import com.villardl.ebookrealb.entity.picebook;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UploadFileDao extends MongoRepository<picebook,String> {
    public picebook findByIsbn(Integer isbn);
}

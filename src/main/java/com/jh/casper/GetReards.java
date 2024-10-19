package com.jh.casper;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import com.casper.sdk.identifier.block.HashBlockIdentifier;
import com.casper.sdk.identifier.era.BlockEraIdentifier;
import com.casper.sdk.model.key.PublicKey;
import com.casper.sdk.model.reward.GetRewardResult;
import com.casper.sdk.service.CasperService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class GetReards {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, IllegalArgumentException {
        System.out.println("== start ==");

        CasperService casperService = CasperService.usingPeer("3.139.219.212", 7777);
        // By validator, era identifier and delegator
        GetRewardResult rewardInfo = casperService.getReward(
                BlockEraIdentifier.builder()
                        .blockIdentifier(HashBlockIdentifier.builder()
                                .hash("5438ea5f003d3d2b2b0a7b59aa54f79761ac5eb0f10f8585cd79a7bb86367cc9").build())
                        .build(),
                // validator
                PublicKey.fromTaggedHexString("0140a48b549ae33cf28e39241a33dd5e22f491d8811f9d83981f3549d418e06da0"),
                // delegator
                PublicKey.fromTaggedHexString("016470ae57b0a3ad5a679d2e0422909bfb9ded445e20cbe6b4c9806f844c94d401"));
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(rewardInfo);
        System.out.println(json);

        System.out.println("== end ==");
    }
}

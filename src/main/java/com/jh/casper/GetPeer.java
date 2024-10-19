package com.jh.casper;

import java.io.IOException;
import com.casper.sdk.service.CasperService;
import com.casper.sdk.model.peer.PeerData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class GetPeer {

    public static void main(String[] args) throws IOException {
        System.out.println("== start ==");

        final CasperService casperService = CasperService.usingPeer("3.14.48.188", 7777);

        final PeerData peerData = casperService.getPeerData();
        System.out.println(peerData.getPeers());
        System.out.println("end");
        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String json = ow.writeValueAsString(peerData);
        System.out.println(json);

        System.out.println("== end ==");
    }
}

// devnet ips()
// 3.14.48.188
// 3.139.219.212
// 18.218.51.191
// 3.20.57.210
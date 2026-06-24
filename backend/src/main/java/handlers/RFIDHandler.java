package handlers;

import dto.RFIDScanDTO;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.RoutingContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RFIDHandler {

    private final List<RFIDScanDTO> scans = Collections.synchronizedList(new ArrayList<>());

    public void handlePostScan(RoutingContext ctx) {
        JsonObject body;
        try {
            body = ctx.body().asJsonObject();
            if (body == null) {
                sendError(ctx, 400, "Invalid JSON");
                return;
            }
        } catch (Exception e) {
            sendError(ctx, 400, "Invalid JSON");
            return;
        }

        String uid = body.getString("uid");
        String status = body.getString("status");
        String readerId = body.getString("readerId");
        String timestamp = body.getString("timestamp");

        if (uid == null || uid.trim().isEmpty()) {
            sendError(ctx, 400, "UID is required");
            return;
        }
        if (status == null || status.trim().isEmpty()) {
            sendError(ctx, 400, "Status is required");
            return;
        }
        if (readerId == null || readerId.trim().isEmpty()) {
            sendError(ctx, 400, "ReaderId is required");
            return;
        }

        RFIDScanDTO scan = new RFIDScanDTO(uid, status, readerId, timestamp);
        scans.add(scan);

        System.out.println("=================================");
        System.out.println("RFID SCAN RECEIVED");
        System.out.println();
        System.out.println("UID: " + scan.getUid());
        System.out.println("STATUS: " + scan.getStatus());
        System.out.println("READER: " + scan.getReaderId());
        System.out.println("TIME: " + (scan.getTimestamp() != null ? scan.getTimestamp() : ""));
        System.out.println();
        System.out.println("=================================");

        JsonObject response = new JsonObject()
                .put("success", true)
                .put("message", "RFID Scan Received");

        ctx.response()
                .setStatusCode(200)
                .putHeader("content-type", "application/json")
                .end(response.encode());
    }

    public void handleGetScans(RoutingContext ctx) {
        JsonArray array = new JsonArray();
        synchronized (scans) {
            for (RFIDScanDTO scan : scans) {
                JsonObject obj = new JsonObject()
                        .put("uid", scan.getUid())
                        .put("status", scan.getStatus())
                        .put("readerId", scan.getReaderId())
                        .put("timestamp", scan.getTimestamp());
                array.add(obj);
            }
        }
        ctx.response()
                .setStatusCode(200)
                .putHeader("content-type", "application/json")
                .end(array.encode());
    }

    private void sendError(RoutingContext ctx, int statusCode, String message) {
        JsonObject response = new JsonObject()
                .put("success", false)
                .put("message", message);
        ctx.response()
                .setStatusCode(statusCode)
                .putHeader("content-type", "application/json")
                .end(response.encode());
    }
}

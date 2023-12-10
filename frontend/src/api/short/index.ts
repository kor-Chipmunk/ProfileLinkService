import http from "@/api/core";
import type { ShortRequest, ShortResponse } from "@/types/shorts";

export const postShort = (shortRequest: ShortRequest): Promise<ShortResponse> =>
  http.post("/shorts", {
    data: shortRequest,
  });

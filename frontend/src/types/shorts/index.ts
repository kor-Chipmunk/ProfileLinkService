export type SocialType = "KAKAO";

export interface ShortRequest {
  originUrl: string;
}

export interface ShortResponse {
  shortUrl: string;
  originUrl: string;
}

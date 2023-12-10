import React, { useState } from "react";
import type { NextPage } from "next";
import styled from "@emotion/styled";
import { Box, Button, Container, Stack, TextField } from "@mui/material";
import { postShort } from "@/api/short";
import { ShortResponse } from "@/types/shorts";
import ShortURLBox from "@/components/domains/ShortURLBox";

const HomePage: NextPage = () => {
  const [originUrl, setOriginUrl] = useState("");
  const [shortUrl, setShortUrl] = useState("");

  const [isError, setIsError] = useState(false);

  const [capturedOriginUrl, setCapturedOriginUrl] = useState("");

  const shortenOnClick = async () => {
    try {
      const response: ShortResponse = await postShort({
        originUrl,
      });

      setShortUrl(
        `${process.env.NEXT_PUBLIC_SERVER_DEFAULT_END_POINT}/${response.id}`
      );
      setCapturedOriginUrl(originUrl);

      setIsError(false);
    } catch (error) {
      setIsError(true);
    }
  };

  const handleOnChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setOriginUrl(e.target.value);
  };

  const handleOnKeyDown = async (e: React.KeyboardEvent<HTMLInputElement>) => {
    if (e.key === "Enter") {
      await shortenOnClick();
    }
  };

  return (
    <Container maxWidth="sm">
      <Stack spacing={5} marginTop={10}>
        <Stack spacing={2} marginTop={10}>
          <S.Header>🎉 단축할 주소를 입력해 주세요.</S.Header>
          <TextField
            variant="outlined"
            placeholder="https://"
            value={originUrl}
            onChange={handleOnChange}
            onKeyDown={handleOnKeyDown}
            error={isError}
            helperText={isError ? "주소가 올바르지 않아요!" : ""}
          />
          <Box display={"flex"} justifyContent={"start"}>
            <Button variant="contained" size="large" onClick={shortenOnClick}>
              단축하기
            </Button>
          </Box>
        </Stack>
        <ShortURLBox shortUrl={shortUrl} originUrl={capturedOriginUrl} />
      </Stack>
    </Container>
  );
};

const S = {
  Header: styled.div`
    flex: 1;
    font-weight: 600;
    font-size: 24px;
    line-height: 34.8px;
    letter-spacing: -0.25px;
    color: white;
  `,
};

export default HomePage;

import React, { useEffect, useState } from "react";
import styled from "@emotion/styled";
import { Box, Button, IconButton, Snackbar, Stack } from "@mui/material";
import ContentCopy from "@mui/icons-material/ContentCopy";

interface ShortURLProps {
  shortUrl: string;
  originUrl: string;
}

const ShortURLBox = ({ shortUrl, originUrl }: ShortURLProps) => {
  const [open, setOpen] = useState(false);

  const handleClick = () => {
    setOpen(true);
    navigator.clipboard.writeText(shortUrl);
  };

  if (shortUrl == "") {
    return <></>;
  }

  return (
    <Stack spacing={2}>
      <S.Header>🎁 단축 주소가 도착했습니다.</S.Header>
      <S.Stack>
        <Box
          display={"flex"}
          justifyContent={"space-between"}
          alignItems={"center"}
        >
          <S.Link href={shortUrl} target="_blank">
            {shortUrl}
          </S.Link>
          <Button onClick={handleClick} color="primary" size="large">
            <ContentCopy />
            &nbsp;복사
          </Button>
        </Box>
        <S.SubLink href={originUrl} target="_blank">
          {originUrl}
        </S.SubLink>
      </S.Stack>
      <S.Snackbar
        message={"단축 주소를 복사했습니다!"}
        anchorOrigin={{ vertical: "top", horizontal: "center" }}
        autoHideDuration={2000}
        onClose={() => setOpen(false)}
        open={open}
      />
    </Stack>
  );
};

const S = {
  Header: styled.div`
    flex: 1;
    font-weight: 600;
    font-size: 24px;
    line-height: 34.8px;
    letter-spacing: -0.25px;
  `,
  Stack: styled(Stack)`
    border: 1px solid gray;
    border-radius: 5px;
    padding: 20px;
  `,
  Snackbar: styled(Snackbar)`
    white-space: pre-line;
    text-align: center;
  `,
  Link: styled.a`
    font-weight: 600;
    font-size: 16px;
    line-height: 32.8px;
    letter-spacing: -0.25px;
    color: orange;
  `,
  SubLink: styled.a`
    font-weight: 400;
    font-size: 16px;
    line-height: 32.8px;
    letter-spacing: -0.25px;
    color: gray;
  `,
};

export default ShortURLBox;

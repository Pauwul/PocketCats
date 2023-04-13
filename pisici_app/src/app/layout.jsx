import '../design_css/globals.css';
import React from 'react';
import Head from 'next/head';

export const metadata = {
  title: 'PocketCats',
  description: 'Generated by create next app',
}

export default function RootLayout({ children }) {
  return (
    <>
      <Head>
        <meta charSet="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <meta name="description" content={metadata.description} />
        <title>{metadata.title}</title>
        <html lang="en" />
      </Head>
      {children}
    </>
  );
}

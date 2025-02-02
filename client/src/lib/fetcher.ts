const fetcher = (url: string, token?: string) =>
    fetch(url, {
        headers: {
            Authorization: `Bearer ${token}`,
            Accept: 'application/json',
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*',
        },
        method: 'GET',
    }).then((res) => res.json());

export default fetcher;

import { AuthContext } from '@/features/auth/contexts/AuthProvider';
import { useContext } from 'react';
import useSWR from 'swr'

const fetcher = (url: string, token?: string) => fetch(url, {
    headers: {
        Authorization: `Bearer ${token}`,
        Accept: 'application/json',
        'Content-Type': 'application/json',
        'Access-Control-Allow-Origin': '*',
    },
    method: "GET"
}).then((res) => res.json())

export default function useFetchList() {
    const context = useContext(AuthContext);

    const { data, error } = useSWR([`http://${process.env.NEXT_PUBLIC_API_BASE_URL}/api/user/list`, context?.idToken], ([url, token]) => fetcher(url, token!));

    return {
        data,
        error
    }
}
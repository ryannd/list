import { AuthContext } from '@/features/auth/contexts/AuthProvider';
import { Watchlist } from '@/features/list/types';
import fetcher from '@/lib/fetcher';
import { useContext } from 'react';
import useSWR from 'swr';

export default function useFetchList() {
    const context = useContext(AuthContext);

    const { data, error } = useSWR<Watchlist>(
        [
            `http://${process.env.NEXT_PUBLIC_API_BASE_URL}/api/user/list`,
            context?.idToken,
        ],
        ([url, token]) => fetcher(url, token as string),
    );

    return {
        data,
        error,
    };
}
